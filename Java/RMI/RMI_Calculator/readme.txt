1. run make

2. In one command window:

rmiregistry


3. In another command window on same machine:

java -Djava.rmi.server.codebase=file:/home/wmaclean/cspp51024/wmaclean_hw1/RMI_Calculator/ 
-Djava.security.policy=/home/wmaclean/cspp51024/wmaclean_hw1/RMI_Calculator/policy 
edu.cspp51024.wmaclean.CalcServerImpl

4. In yet another command window on the same machine:

java -Djava.security.policy=/home/wmaclean/cspp51024/wmaclean_hw1/RMI_Calculator/policy edu.cspp51024.wmaclean.CalcClient

