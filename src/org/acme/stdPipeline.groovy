#!/bin/groovy
package org.acme;
import groovy.util.*
//@Grab(group="org.yaml", module="snakeyaml", version="1.20")

import org.yaml.snakeyaml.*
@NonCps
def execute() {

  node {

    stage('Checkout') {
      checkout scm
    }
	echo 'Loading pipeline definition'
    Yaml parser = new Yaml()
    Map pipelineDefinition = parser.load(new File(pwd() + '/pipeline.yaml').text)
    println pipelineDefinition
	switch(pipelineDefinition.pipelineType) {		
		case 'python':
			// Instantiate and execute a Python pipeline
			//new pythonPipeline(pipelineDefinition).executePipeline()
			println "in python"
			if(pipelineDefinition.runTests){
				echo "In if"
				stage('Run testcases'){
					//new pythonPipeline().executeTestCases(pipelineDefinition)
					//sh "echo bharath"
					echo "bharath"
				}
			}
			//if(pipelineDefinition.deployUponTestSuccess){
		        if(pipelineDefinition.runTests){
				echo "In another if"
				stage('Deployment'){
					
					//new pythonPipeline().executeDeployment()
					echo "kumar"
				}
			}
		case 'nodejs':
			// Instantiate and execute a NodeJS pipeline
			new nodeJSPipeline(pipelineDefinition).executePipeline()
		}
	}
  }
