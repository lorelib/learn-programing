namespace java com.lorelib.rpc.thrift

service UserService {
    string getUserName(1:i64 companyId, 2:string userId)

    User getUser(1:string userId)
}

struct User {
    1:i64 id
    2:string userId
    3:string userName
}