@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import groovy.io.FileType
def http = new HTTPBuilder( 'http://192.168.56.4:8081' )
http.get( path: '/service/siesta/rest/beta/components', query: [repositoryId: "Artifact-storage"] ) { resp, reader ->
    net.sf.json.JSONObject read = reader
    //print read.items.name.tolist()
    line = read.items.name
    line.each {
        if (it.endsWith(".tar.gz")) {
            println "${it}"
        }
    }
}

def list = ["Apple", "Banana", "Orange"]
list.each {
    print "${it}"
}

/* def http2 = new HTTPBuilder( 'http://192.168.56.4:8081')
http2.auth.basic('admin', 'admin123')
http2.post(path:'/repository/maven-public/', body : new File('JavaSample-13.tar.gz'), requestContentType : application/data) { response ->
  println response.statusLine }




/* BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
print "Build name? "
def name = br.readLine()
def http3 = new HTTPBuilder( 'http://192.168.56.4:8081' )
http3.get( path: '/service/siesta/rest/beta/search', query: [name: "${name}"] ) { resp, reader ->
//println resp.status
    net.sf.json.JSONObject read = reader
    //println read.get("items").name[0]


    link = "http://192.168.56.4:8081/repository"
    repository = "Artifact-storage"
    dllink = "${link}/${repository}/${name}"

    def file = new File("${name}").newOutputStream()
    file << new URL(dllink).openStream()
    file.close()
} */

/*URL url = new URL("http://192.168.56.4:8081/repository/maven-releases/repository/8/Java-CI-Storage/Java-CI-app-8/1/Java-CI-app-8-1.tar.gz")
def authString = "admin:admin123".getBytes().encodeBase64().toString()
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
httpCon.setDoOutput(true);
httpCon.setRequestMethod("PUT");
httpCon.setRequestProperty( "Authorization", "Basic ${authString}" )
def file = new File("/opt/jenkins/master/workspace/ADMIN-job1/build/libs/java-CI.tar.gz").bytes
def out = new DataOutputStream(httpCon.outputStream)
out.write(file);
out.flush()
out.close();
println(httpCon.getResponseCode())

URL url = new URL("http://192.168.56.4:8081/repository/java-releases/java-ci-group/java/3/java-3.tar.gz")
def authString = "admin:admin123".getBytes().encodeBase64().toString()
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
httpCon.setDoOutput(true);
httpCon.setRequestMethod("PUT");
httpCon.setRequestProperty( "Authorization", "Basic ${authString}" )
def file = new File("/opt/jenkins/master/workspace/ADMIN-job1/build/libs/java-CI.tar.gz").bytes
def out = new DataOutputStream(httpCon.outputStream)
out.write(file);
out.flush()
out.close();
println(httpCon.getResponseCode())



@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import groovy.io.FileType
def http = new HTTPBuilder( 'http://192.168.56.4:8081' )
http.get( path: '/service/siesta/rest/beta/components', query: [repositoryId: "maven-releases"] ) { resp, reader ->
    net.sf.json.JSONObject read = reader
    //print read.items.name.tolist()
    line = read.items.name
    println line
    line.each {
        if (it.endsWith(".tar.gz")) {
            println "${it}"
        }
    }
}

def env = System.getenv()
String version = env['foo']

//BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
//print "Insert name from above list? "
//def name = br.readLine()
//name = System.console().readLine 'Insert name to download from above list '
//def http3 = new HTTPBuilder( 'http://192.168.56.4:8081' )
//http3.get( path: '/service/siesta/rest/beta/search', query: [name: "${name}"] ) { resp, reader ->
//println resp.status
  //  net.sf.json.JSONObject read = reader
  //  println "Artifact GAVS:"
  //  println read.get("items").name[0]
  //  println read.get("items").id[0]

//http://192.168.56.4:8081/repository/java-releases/java-ci-group/java/3/java-3.tar.gz

    link = "http://192.168.56.4:8081/repository"
    repository = "java-releases"
    groupid = "java-ci-group"
    name = "java"
    dllink = "${link}/${repository}/${groupid}/${name}/${version}/${name}-${version}"+".tar.gz"

    def file = new File("/opt/jenkins/master/artifacts/${name}-${version}"+".tar.gz").newOutputStream()
    file << new URL(dllink).openStream()
    file.close()
