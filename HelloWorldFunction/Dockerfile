FROM ubuntu:latest
LABEL authors="liamh"

ENTRYPOINT ["top", "-b"]
FROM public.ecr.aws/lambda/java:17
# Install Graphviz
RUN yum -y update && \
    yum -y install graphviz && \
    yum clean all

# Copy the function's jar file and dependencies into the container
COPY target/your-lambda-handler.jar ${LAMBDA_TASK_ROOT}/lib/
COPY target/dependency-jars/* ${LAMBDA_TASK_ROOT}/lib/

# Set the command to run your Lambda function handler
CMD ["helloworld.App::handleRequest"]