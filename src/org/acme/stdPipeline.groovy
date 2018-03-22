#!/bin/groovy
package org.acme;
import groovy.util.*
//@Grab(group="org.yaml", module="snakeyaml", version="1.20")

import org.yaml.snakeyaml.*

def execute() {

  node {

    stage('Initialize') {
      checkout scm
      echo 'Loading pipeline definition'
      Yaml parser = new Yaml()
      Map pipelineDefinition = parser.load(new File(pwd() + '/pipeline.yaml').text)
      println pipelineDefinition
      //typePipeline=pipelineDefinition.pipelineType
      //def typePipeline="python"
    //}  

		switch(pipelineDefinition.pipelineType) {
		case 'python':
			// Instantiate and execute a Python pipeline
			//new pythonPipeline(pipelineDefinition).executePipeline()
			new pythonPipeline(pipelineDefinition).executePipeline()
		case 'nodejs':
			// Instantiate and execute a NodeJS pipeline
			new nodeJSPipeline(pipelineDefinition).executePipeline()
		}
	}
  }

}
return this
