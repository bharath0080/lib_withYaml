#!/bin/groovy
package org.acme;
import groovy.util.*
def execute() {

  node {

    stage('Checkout') {
      checkout scm
    }
	echo 'Loading pipeline definition'
   config = readYaml file: "./pipeline.yaml"
   println config
   if(config.pipelineType == "python"){
		println "in python"
			if(config.runTests){
				echo "In if"
				stage('Run testcases'){
					new pythonPipeline().executeTestCases(config)
				}
			}
			if(config.deployUponTestSuccess){
		        
				echo "In another if"
				stage('Deployment'){
					
					new pythonPipeline().executeDeployment(config)
					echo "kumar"
				}
			}
	}else if (config.pipelineType == "nodejs"){
			echo "In Nodejs"
	
	}
  }
}
