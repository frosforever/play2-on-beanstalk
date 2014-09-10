Play deployed on Beanstalk via docker
=================================

Develop locally as normal.

To distribute as docker:

```
./activator docker:stage
```

Then in ```target/docker``` you will have a Dockerfile and the app ready to build.

```
cp Dockerrun.aws.json target/docker
cd target/docker
zip -r ../BeanStalkApp.zip .
```
