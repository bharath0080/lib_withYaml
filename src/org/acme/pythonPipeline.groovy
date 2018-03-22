#!/usr/bin/groovy
package org.acme;
import org.yaml.snakeyaml.*
def executePipeline (){
 node {
      Yaml parser = new Yaml()
      Map pipelineDefinition1 = parser.load(new File(pwd() + '/pipeline.yaml').text)  
    //println pipelineDefinition
    if (pipelineDefinition1.runTests) {
      stage('Run Tests') {
        //sh pd.testCommand
	sh "echo Running the testcases"
      }
    }

    if (pipelineDefinition1.deployUponTestSuccess) {
      stage('Deploy') {
        //sh "path/to/a/deploy/bash/script.sh ${pd.deploymentEnvironment}"
	sh "echo deploying the application"
      }
    }
  }
}

return this
