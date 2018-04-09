#!/usr/bin/groovy
package org.acme;

def clone(){
	git 'https://github.com/bharath0080/SampleStudentProject.git'
}
def build(){
	sh "'mvn' -Dmaven.test.failure.ignore clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true -Dsonar.jacoco.reportMissing.force.zero=True -Dsonar.junit.reportsPath=target/surefire-reports org.sonarsource.scanner.maven:sonar-maven-plugin:3.3.0.603:sonar -Dsonar.host.url=http://10.242.138.71:9000 -Dsonar.login=admin -Dsonar.password=admin"
}
def results(){
	jacoco maximumLineCoverage: '80', minimumLineCoverage: '80'
}
