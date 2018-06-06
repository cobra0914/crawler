FROM centos
MAINTAINER cobra
ADD jetbrains /usr/local/bin/jetbrains
EXPOSE 1027
CMD ["jetbrains"]
