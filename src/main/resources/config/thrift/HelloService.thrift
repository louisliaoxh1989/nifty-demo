namespace java com.jonsen.nifty.demo.thrift  // defines the namespace  
   
typedef i32 int  //typedefs to get convenient names for your types 
   
service HelloService {  
	string sayHello(1:string name),//delay 3s
}