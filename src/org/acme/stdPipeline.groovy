#!/bin/groovy
package org.acme;
import groovy.util.*
//@Grab(group="org.yaml", module="snakeyaml", version="1.20")

import org.yaml.snakeyaml.*
class git implements Serializable {
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
			
			if(pipelineDefinition.runTests){
				stage('Run testcases'){
					//new pythonPipeline().executeTestCases(pipelineDefinition)
					//sh "echo bharath"
					echo bharath
				}
			}
			if(pipelineDefinition.deployUponTestSuccess){
				stage('Deployment'){
					new pythonPipeline().executeDeployment()
				}
			}
		case 'nodejs':
			// Instantiate and execute a NodeJS pipeline
			new nodeJSPipeline(pipelineDefinition).executePipeline()
		}
	}
  }
}
return this
