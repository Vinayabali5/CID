# CID - College Information Database

## Building docker images

The following commands can be used to build the docker images for the CID API and UI:

```bash
./scripts/build-docker.sh --component { COMPONENT NAME } -v { VERSION }
```

This command executes a shell script that will run the various docker commands to build the image based on the current state of the source code in the directory. If you want more information about what is happening in the background you can add the argument _--verbose_ to log all output to the console. For information about the other arguments use the _--help_ argument. 

The script will output a log file into the base folder with the file name __build-{ COMPONENT NAME }.log__ with details of build process. This is the same output that appears with the _--verbose_ argument.

By default the build script will calculate the appropriate Docker Image Tag for the particular build. The tag will be something like registry.reigate.ac.uk/cid/cis-api:1.3.2 (see below for an explanation of Docker Image Tags). The tag for your newly created image will appear on the command line, this will be used later for running, publishing and deploying the docker image.

### Docker Image Tag - explained

The ```docker build``` command required that a tag (-t) is supplied to label/name the image built. The format for these image names is as follows:

```bash
[{docker_registry_server}[:{port}]/][{project}/]{application}:{version}
```

| Variable | Value To Use | Required |
| --- | --- | --- |
| docker_registry_server | registry.reigate.ac.uk | No - Required for remote storage |
| port | no port | No - Required for remote storage  |
| project | cid | No - This is useful to organise images into projects |
| application | cis-api or cis-ui (note: use this for cis-template project builds) | Yes |
| version | the version number of the build | Yes |

An example of the docker image tag to use for the cis-api application would be ```registry.reigate.ac.uk/cid/cis-api:1.3.0```. 

## Running the docker images

To run these images locally you can create .env files in the cis-api and cis-template folders based off the .env_sample files supplied. Once these have been created you can then run the following commands to run the docker images:

```bash
docker run --rm --env-file ./cis-api/.env -p 8080:8080 {Docker Image Tag}
```

```bash
docker run --rm --env-file ./cis-template/.env -p 80:8080 {Docker Image Tag}
```

## Publish the docker images

The docker image that are created by the ```docker build``` command are stored locally so for them to be used elsewhere they need to be published to a docker registry server. If during the docker image creation you supplied the docker registry server variable then this is the server that the image will be published to.

To publish a docker image you run the following command:

```bash
docker push {Docker Image Tag}
```

This will upload the locally stored docker image from your local machine to the docker registry server. This image can then be accessed by any system with access to that docker registry.
