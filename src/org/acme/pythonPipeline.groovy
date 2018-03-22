#!/usr/bin/groovy
//package org.acme;
import org.acme.*

pythonPipeline(pipelineDefinition) {
   def pipelineType = null
  // Create a globally accessible variable that makes
  // the YAML pipeline definition available to all scripts
  println "In pythonpipeline function"
  pd = pipelineDefinition
}

def executePipeline() {
  println "In execute pipeline"
  node {
    if (runTests) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "echo Running the testcases"
      }
    }

    if (deployUponTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "echo deploying the application"
      }
    }
  }
}

return this
