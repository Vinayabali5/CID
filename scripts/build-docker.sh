#!/bin/bash
DEFAULT_SERVER=registry.reigate.ac.uk
DEFAULT_PORT=
DEFAULT_APP_NAME=cid

LOCAL_BUILD=0

VERBOSE=0

function help() {
    echo "Usage:"
    echo " --component {component}  The name of the component to build."
    echo " -v {version}             Version number."
    echo " -l                       Local build. This will build the docker image for local use only."
    echo " -s {server}              (optional) Docker Repository Server (default: $DEFAULT_SERVER)."
    echo " -p {port}                (optional) Docker Repository Server port (default: $DEFAULT_PORT)."
    echo " -a {app name}            (optional) Docker Repositroy Application Name (default: $DEFAULT_APP_NAME)."
    echo " --verbose | -V           Verbose logging for the docker build process."
    echo " -h | --help              Displays this help mesage."
    exit 1
}

buildComponent() {
    COMPONENT_NAME=$1
    echo "Building Docker Image: ${TAG}"
    if [ ${VERBOSE} -eq 1 ]; 
    then 
        docker build -t ${TAG} -f ./${COMPONENT_NAME}/Dockerfile . | tee build-${COMPONENT}.log
    else
        docker build -t ${TAG} -f ./${COMPONENT_NAME}/Dockerfile . > build-${COMPONENT}.log
    fi
}

while [[ "$#" -gt 0 ]]; 
do
    case $1 in
        -h|--help) help;;
        --component) COMPONENT="$2"; shift;;
        -v) VERSION="$2"; shift;;
        -l) LOCAL_BUILD=1;;
        -s) SERVER="$2"; shift;;
        -p) PORT="$2"; shift;;
        -a) APP_NAME="$2"; shift;;
        --verbose|-V) VERBOSE=1;;
        *) echo "Unknown parameter passed: $1"; help;;
    esac
    shift
done

# Check that a component name has been supplied
if [ -z ${COMPONENT} ]; then
    echo "Error: You must specify a components for the build script to work correctly. "
    echo ""
    help;
fi

# This renames the component image name when build cis-template to cis-ui
COMPONENT_IMAGE_NAME=${COMPONENT}
if [ "$COMPONENT" = "cis-template" ]; then
    COMPONENT_IMAGE_NAME=cis-ui
fi
if [ "$COMPONENT" = "cis-ui" ]; then
    COMPONENT_IMAGE_NAME=${COMPONENT}
    COMPONENT=cis-template
fi
if [ "$COMPONENT" = "ui" ]; then
    COMPONENT_IMAGE_NAME=cis-ui
    COMPONENT=cis-template
fi
if [ "$COMPONENT" = "api" ]; then
    COMPONENT_IMAGE_NAME=cis-api
    COMPONENT=cis-api
fi

# Check that a version number has been supplied
if [ -z ${VERSION} ]; 
then
    echo "Error: You must specify a version number for the build script to work correctly. "
    echo ""
    help;
fi

# Check that no server has been provided when running a local build
if [ ${LOCAL_BUILD} -eq 1 ] && [ -n ${SERVER} ]; 
then 
    echo "Warning: you have specified a server when running a local build. The server parameter will be ignored."
    echo ""
fi

if [ -z ${SERVER} ]; then SERVER=${DEFAULT_SERVER}; fi
if [ -z ${PORT} ] && [ -z ${DEFULT_PORT}]; 
then
    PORT=${DEFAULT_PORT}; 
fi
if [ -z ${APP_NAME} ]; then APP_NAME=${DEFAULT_APP_NAME}; fi

if [ ${LOCAL_BUILD} -eq 0 ]; 
then
    if [ -z ${PORT} ]; 
    then 
        TAG=${SERVER}/${APP_NAME}/${COMPONENT_IMAGE_NAME}:${VERSION}
    else 
        TAG=${SERVER}:${PORT}/${APP_NAME}/${COMPONENT_IMAGE_NAME}:${VERSION}
    fi
else
    TAG=${APP_NAME}/${COMPONENT_IMAGE_NAME}:${VERSION}
fi

buildComponent ${COMPONENT}
