# 接口文件
namespace java com.lorelib.rpc.thrift

service HelloService {
    string helloString(1:string word)
}