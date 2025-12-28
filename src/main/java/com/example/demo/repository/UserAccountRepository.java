[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[21,17] cannot find symbol
  symbol:   method getUsername()
  location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[22,17] cannot find symbol
  symbol:   method setUsername(java.lang.String)
  location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[24,13] cannot find symbol
  symbol:   method setActive(boolean)
  location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[46,13] cannot find symbol
  symbol:   method setActive(boolean)
  location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ViolationRecordServiceImpl.java:[21,15] cannot find symbol
  symbol:   method setResolved(boolean)
  location: variable record of type com.example.demo.entity.ViolationRecord
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ViolationRecordServiceImpl.java:[34,15] cannot find symbol
  symbol:   method setResolved(boolean)
  location: variable record of type com.example.demo.entity.ViolationRecord
[INFO] 6 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:12 min
[INFO] Finished at: 2025-12-28T21:19:56Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[21,17] cannot find symbol
[ERROR]   symbol:   method getUsername()
[ERROR]   location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[22,17] cannot find symbol
[ERROR]   symbol:   method setUsername(java.lang.String)
[ERROR]   location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[24,13] cannot find symbol
[ERROR]   symbol:   method setActive(boolean)
[ERROR]   location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserAccountServiceImpl.java:[46,13] cannot find symbol
[ERROR]   symbol:   method setActive(boolean)
[ERROR]   location: variable user of type com.example.demo.entity.UserAccount
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ViolationRecordServiceImpl.java:[21,15] cannot find symbol
[ERROR]   symbol:   method setResolved(boolean)
[ERROR]   location: variable record of type com.example.demo.entity.ViolationRecord
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ViolationRecordServiceImpl.java:[34,15] cannot find symbol
[ERROR]   symbol:   method setResolved(boolean)
[ERROR]   location: variable record of type com.example.demo.entity.ViolationRecord
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@5778ba1319ba:~/Workspace/demo$ 