#!/usr/bin/groovy
package org.acme;
/*
pythonPipeline(pipelineDefinition) {
  // Create a globally accessible variable that makes
  // the YAML pipeline definition available to all scripts
  pd = pipelineDefinition
}
*/
//def executePipeline(Map pipelineDefinition) {
def executePipeline() {
  node {
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
