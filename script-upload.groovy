//def env = System.getenv()
//String version = env['bar']

def version = System.getProperty('ver')

    link = "http://192.168.56.4:8081/repository"
    repository = "java-releases"
    groupid = "java-ci-group"
    name = "java"


URL url = new URL("${link}/${repository}/${groupid}/${name}/${version}/${name}-${version}"+".tar.gz")
def authString = "admin:admin123".getBytes().encodeBase64().toString()
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection()
httpCon.setDoOutput(true)
httpCon.setRequestMethod("PUT")
httpCon.setRequestProperty( "Authorization", "Basic ${authString}" )
def file = new File("/opt/jenkins/master/workspace/ADMIN-job1/build/libs/java-CI.tar.gz").bytes
def out = new DataOutputStream(httpCon.outputStream)
out.write(file)
out.flush()
out.close()
println(httpCon.getResponseCode())

