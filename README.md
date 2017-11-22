### Nexus 3 upload/download scripts on Groovy
## For your Jenkins automation you can use this scripts as examples
```
# groovy -DArtifactId=$BUILD_NUMBER script.groovy
```
## Pass variables to script, put this on script
```
def ArtID = System.get.Property('ArtifactId')
```
