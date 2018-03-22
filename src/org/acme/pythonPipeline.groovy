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

def executePipeline implements Serializable (Map pipelineDefinition){
  println "In execute pipeline"
  println pipelineDefinition
  def runTest = pipelineDefinition.runTests
  def deployOnTestSuccess = pipelineDefinition.deployUponTestSuccess
  node {
    //println pipelineDefinition
    if (runTest) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "echo Running the testcases"
      }
    }

    if (deployOnTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "echo deploying the application"
      }
    }
  }
}

return this
