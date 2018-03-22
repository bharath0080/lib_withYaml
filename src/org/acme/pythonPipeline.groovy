#!/usr/bin/groovy
package org.acme;
import org.yaml.snakeyaml.*
def executeTestCases (pipelineDefinition){
 	sh "Running testcases"
	sh pipelineDefinition.testCommand
}
def executeDeployment(){
	sh "Deploying"
}
return this
