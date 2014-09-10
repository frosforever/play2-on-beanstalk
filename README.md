Play2 deployed on Beanstalk via docker
=================================

Develop locally as normal. Use ```./activator run``` and so on.

# Freestyle build step on DEV@cloud Jenkins

```
rm -rf Beanstalk.zip
./activator docker:stage
cd target/docker
zip -r ../../Beanstalk.zip . 
```

Then use AWS deployer to select Beanstalk.zip


# Manual deployment via beanstalk

```
./activator docker:stage
```

Then in ```target/docker``` you will have a Dockerfile and the app ready to build.

To prepare for beanstalk, create a zip:

```
cd target/docker
zip -r ../BeanStalkApp.zip .
```

Deploy this zip file via the Beanstalk console (as a docker app).


## How it works

The generated Dockerfile will look like this (you shouldn't need to edit it):

```
FROM dockerfile/java
MAINTAINER John Smith <john.smith@example.com>
EXPOSE 9000
ADD files /
WORKDIR /opt/docker
RUN ["chown", "-R", "daemon", "."]
USER daemon
ENTRYPOINT ["bin/test-act-docker"]
CMD []
```

This must be at the root of the Zip. This Adds the build play artifacts to the root
of the container, which will be build on the first node is lands on on
beanstalk. First deploys of brand new apps will take a bit longer than updates.
