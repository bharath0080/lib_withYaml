#!/usr/bin/groovy
package org.acme;

pythonPipeline(pipelineDefinition) {
  // Create a globally accessible variable that makes
  // the YAML pipeline definition available to all scripts
  pd = pipelineDefinition
}

def executePipeline() {
  node('linux') {
    if (runTests) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "Running the testcases"
      }
    }

    if (deployUponTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "deploying the application"
      }
    }
  }
}

return this
