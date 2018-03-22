#!/usr/bin/groovy
package org.acme;

/*
pythonPipeline(pipelineDefinition) {
   def pipelineType = null
  // Create a globally accessible variable that makes
  // the YAML pipeline definition available to all scripts
  println "In pythonpipeline function"
  pd = pipelineDefinition
 }
*/

def executePipeline (Map body){
	def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()
  println "In execute pipeline"
  println pipelineDefinition
  def runTest = config.runTests
  println runTest
  def deployOnTestSuccess = config.deployUponTestSuccess
  println deployOnTestSuccess
  node {
    //println pipelineDefinition
    if (config.runTests) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "echo Running the testcases"
      }
    }

    if (config.deployUponTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "echo deploying the application"
      }
    }
  }
}

return this
