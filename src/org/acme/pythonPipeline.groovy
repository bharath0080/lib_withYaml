#!/usr/bin/groovy
package org.acme;
import org.yaml.snakeyaml.*
def executeTestCases (pipelineDefinition){
	println pipelineDefinition
 	sh "Running testcases"
	sh pipelineDefinition.testCommand
}
def executeDeployment(){
	sh "Deploying"
}
return this
