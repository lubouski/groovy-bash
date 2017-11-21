//@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7' )
//import groovyx.net.http.HTTPBuilder
//import static groovyx.net.http.ContentType.*
//import groovy.io.FileType
//def http = new HTTPBuilder( 'http://192.168.56.4:8081' )
//http.get( path: '/service/siesta/rest/beta/components', query: [repositoryId: "Artifact-storage"] ) { resp, reader ->
  //  net.sf.json.JSONObject read = reader
    //print read.items.name.tolist()
  //  line = read.items.name
  //  (line).each {
   //     if (it.endsWith(".tar.gz")) {
    //        println "${it}"
    //    }
  //  }
//}
//def env = System.getenv()
//String version = env['foo']

def version = System.getProperty('ver')

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


