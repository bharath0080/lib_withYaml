#!/bin/groovy
package org.acme;
import groovy.util.*
//@Grab(group="org.yaml", module="snakeyaml", version="1.20")

import org.yaml.snakeyaml.*

def execute() {

  node {

    stage('Checkout') {
      checkout scm
    }
	echo 'Loading pipeline definition'
   config = readYaml file: "./pipeline.yaml"
   println config
	switch(config.pipelineType) {		
		case 'python':
			// Instantiate and execute a Python pipeline
			//new pythonPipeline(config).executePipeline()
			println "in python"
			if(config.runTests){
				echo "In if"
				stage('Run testcases'){
					//new pythonPipeline().executeTestCases(config)
					//sh "echo bharath"
					echo "bharath"
				}
			}
			//if(config.deployUponTestSuccess){
		        
				echo "In another if"
				stage('Deployment'){
					
					//new pythonPipeline().executeDeployment()
					echo "kumar"
				}
			//}
		case 'nodejs':
			// Instantiate and execute a NodeJS pipeline
			new nodeJSPipeline(config).executePipeline()
		}
	}
  }
