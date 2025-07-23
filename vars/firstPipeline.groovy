import com.academy.build.calculator

def call (Map pipelineParams){
    Calculator calculator = new Calculator (this)
    pipeline {
        agent {
        label 'jenkinsslave'
        }
    environment {
         APPLICATION_NAME = "${pipelineParams.appName}"
    }
        stages {
            stage ('calculate') {
                steps {
                    script {
                        echo "*** calling Add method for reusability *** "
                        echo "*** printing sum of two values ***"
                        println calculator.add(2,2)
                    }
                }
            }
            stage ('build') {
                steps {
                    echo "**** building the application **** "
                    echo "*** I am building for ${APPLICATION_NAME}"
                }
            }
            stage ('test') {
                steps {
                    echo "*** testing the application ***"
                }
            }
            stage ('deploy') {
                steps {
                    echo "*** deploying the application"
                }
            }
        }

    }
}

