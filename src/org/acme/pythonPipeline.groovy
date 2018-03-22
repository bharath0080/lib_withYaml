#!/usr/bin/groovy
package org.acme;

def executePipeline (pipelineDefinition){
  println "In execute pipeline"
  println pipelineDefinition
  def runTest = pipelineDefinition.runTests
  println runTest
  def deployOnTestSuccess = pipelineDefinition.deployUponTestSuccess
  println deployOnTestSuccess
  node {
    //println pipelineDefinition
    if (pipelineDefinition.runTests) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "echo Running the testcases"
      }
    }

    if (pipelineDefinition.deployUponTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "echo deploying the application"
      }
    }
  }
}

return this
