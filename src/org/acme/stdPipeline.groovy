#!/bin/groovy
package org.acme;
import groovy.util.*
import org.yaml.snakeyaml.Yaml
//import org.yaml.snakeyaml.Yaml
//@Grab('org.yaml:snakeyaml:1.17')
//@Grab(group="org.yaml", module="snakeyaml", version="1.20")
def execute() {

  node('linux') {

    stage('Initialize') {
      checkout scm
      echo 'Loading pipeline definition'
      Yaml parser = new Yaml()
      Map pipelineDefinition = parser.load(new File(pwd() + '/pipeline.yml').text)
    }

    switch(pipelineDefinition.pipelineType) {
      case 'python':
        // Instantiate and execute a Python pipeline
        new pythonPipeline(pipelineDefinition).executePipeline()
      case 'nodejs':
        // Instantiate and execute a NodeJS pipeline
        new nodeJSPipeline(pipelineDefinition).executePipeline()
    }

  }

}
