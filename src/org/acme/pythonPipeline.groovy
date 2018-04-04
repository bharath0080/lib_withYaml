#!/usr/bin/groovy
package org.acme;

def executeTestCases (config){
	println config
 	sh "Running testcases"
	sh pipelineDefinition.testCommand
}
def executeDeployment(){
	sh "Deploying"
}
return this
