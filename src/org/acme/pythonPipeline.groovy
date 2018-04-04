#!/usr/bin/groovy
package org.acme;

def executeTestCases (config){
	println config
 	sh "echo Running testcases"
	sh config.testCommand
}
def executeDeployment(config){
	sh "echo Deploying"
}
return this
