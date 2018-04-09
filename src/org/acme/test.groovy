#!/bin/groovy
package org.acme;
import groovy.util.*
def execute() {
	node{
	stage('clone'){
		new testing().clone()
	}
	stage('build'){
                new testing().build()

	}
	stage('Results'){
		new testing().results()
	}
	}
}
