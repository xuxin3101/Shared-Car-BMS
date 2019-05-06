# 共享汽车后台管理系统API文档

## 目录

1. [序言](#序言) 
2. [全局code](#全局code)
3. [全局sign算法](#全局sign算法)
4. [用户相关](#用户相关)  
4.1 [登录](#登录)  
4.2 [注册](#注册)  
4.3 [获取用户列表](#获取用户列表)
5. [邮箱相关](#邮箱相关)
6. [管理系统信息相关](#管理系统信息相关)  
6.1 [获取车辆和人数](#获取车辆和人数)
7. [网点相关](#网点相关)  
7.1 [查网点](#查网点)  
7.2 [增加一个网点](#增加一个网点)  
7.3 [删除一个网点](#删除一个网点)  
7.4 [修改一个网点](#修改一个网点)  
8. [工作人员相关](#工作人员相关)  
8.1 [查工作人员](#查工作人员)  
8.2 [增加一个工作人员](#增加一个工作人员)  
8.3 [删除一个工作人员](#删除一个工作人员)  
9. [汽车相关](#汽车相关)  
9.1 [查汽车](#查汽车)  
9.2 [增加一个汽车](#增加一个汽车)  
9.3 [删除一个汽车](#删除一个汽车)

## 序言

- 程序采用前后端分离，本文档提供网络请求API。

## 全局code

返回code|解释
-|-|
1000|成功
1001|sign验证失败
1002|token验证失败
1003|有参数为空
1004|待定
1005|未知失败原因

## 全局sign算法
- 所有的请求在服务器端统一验证sign
- sign由所有POST上传的参数和signstring决定
- 服务器端校验当前上传的timestamp和服务器端的timestamp，若当前timestamp太老，则判断请求失效
- sign算法为所有的参数字典序排序，然后key和value连接起来，最后加signstring，对这个字符串取md5值  
如：上传参数为`username=asadsad&timestamp=1555226180000&sign=f556929c24857816bb52ea5ded41dfb5`  
则对字符串：  
`timestamp1555226180000usernameasadsadqwfhasio4568/asd12iids`  
取md5运算  
即：  
`sign=md5("timestamp1555226180000usernameasadsadqwfhasio4568/asd12iids")`
其中`qwfhasio4568/asd12iids` 是前后端约定的signstring
## 用户相关

### 登录
#### 简要描述：
- 用户登录接口
#### 请求url：
- `/api/login`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
password|是|String|密码
timestamp|是|String|13位当前时间戳
sign|是|String|[sign签名](#全局sign算法)
#### 返回格式
``` json
    {
        "code":1000,
        "msg":"登录成功",
        "userinfo":{
            "username":"用户名",
            "token":"asdasdasd"
        }
    } 
```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|错误说明
code|是|int|[参加全局code](#全局code)
userinfo|是|Object|返回用户信息
- userinfo中的token在登录后的所有操作中均有用到，注意保存

### 注册
#### 简要描述
- 用户注册接口
#### 请求url：
- `/api/register`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
password|是|String|密码
email|是|String|邮箱
code|是|String|邮箱验证码
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
- 注意：注册前要先发送邮箱验证码[发送注册邮箱验证码](#注册邮箱验证码)
#### 返回格式
``` json
{
    msg: "注册成功", 
    code: 1000
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)
### 获取用户列表
#### 简要描述
- 获取用户列表接口
#### 请求url：
- `/api/getusers`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|登录后返回的token
page|是|int|返回第几页数据
count|是|int|返回几条数据
timestamp|是|String|13位当前时间戳
sign|是|String|[sign签名](#全局sign算法)
- 注意：page和count密切相关，如page=2&count=5，则返回数据库的6-10
#### 返回参数说明
``` json
{
    msg: "查询成功", 
    code: 1000,
    userinfos:{
        //用户相关数据
    }
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)
userinfos|否|array|返回的用户列表

## 邮箱相关
### 注册邮箱验证码
#### 简要描述
- 发送邮箱验证码接口
#### 请求url：
- `/api/sendregistermail`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
toAddress|是|String|邮箱
timestamp|是|String|13位当前时间戳
sign|是|String|[sign签名](#全局sign算法)
#### 返回格式
``` json
    {
        "code":1000,
        "msg":"发送成功"
    } 
```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|错误说明
code|是|int|[参加全局code](#全局code)

## 管理系统信息相关
### 获取车辆和人数
#### 简要描述
- 获取车辆和人数
#### 请求url：
- `/api/getindexinfo`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
#### 返回格式
``` json
{
    msg: "注册成功", 
    code: 1000,
    {
        "carcount":10,
        "usercount":10
    }
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

## 网点相关
### 查网点
#### 简要描述
- 获取指定数量的网点信息
#### 请求url：
- `/api/getbranch`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
page|是|int|第几页
count|是|int|获取数量
#### 返回格式
``` json
{
    msg: "注册成功", 
    code: 1000,
    [
        //具体信息
    ]
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 增加一个网点
#### 简要描述
- 增加一个网点
#### 请求url：
- `/api/insertbranch`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
name|是|String|网点名称
type|是|String|网点类型(合作/非合作)
place|是|String|网点地点
count|是|int|网点内车数量
flow|是|int|网点日流量
#### 返回格式
``` json
{
    msg: "添加成功", 
    code: 1000,
    [
        //具体信息
    ]
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 删除一个网点
#### 简要描述
- 删除一个网点
#### 请求url：
- `/api/deletebranch`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
id|是|String|网点id
#### 返回格式
``` json
{
    msg: "删除成功", 
    code: 1000,
    [
        //具体信息
    ]
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 修改一个网点
#### 简要描述
- 修改一个网点
#### 请求url：
- `/api/editbranch`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
name|是|String|网点名称
type|是|String|网点类型(合作/非合作)
place|是|String|网点地点
count|是|int|网点内车数量
flow|是|int|网点日流量
id|是|int|要修改的网点id
#### 返回格式
``` json
{
    msg: "修改成功", 
    code: 1000
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

## 工作人员相关
### 查工作人员
#### 简要描述
- 获取指定数量的工作人员信息
#### 请求url：
- `/api/getworkers`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
page|是|int|第几页
count|是|int|获取数量
#### 返回格式
``` json
{
    "msg": "获取成功", 
    "code": 1000,
    "workersInfos":
    [
        //具体信息
    ],
    "workcount":10
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 增加一个工作人员
#### 简要描述
- 增加一个工作人员
#### 请求url：
- `/api/insertworker`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
name|是|String|员工名字
idcard|否|String|身份证号
phone|否|String|手机号
status|否|String|空闲/加油工单中/保养工单中/...
permission|是|String|城市主管/普通运维
#### 返回格式
``` json
{
    msg: "添加成功", 
    code: 1000
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 删除一个工作人员
#### 简要描述
- 删除一个工作人员
#### 请求url：
- `/api/deleteworker`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
id|是|String|员工id
#### 返回格式
``` json
{
    msg: "删除成功", 
    code: 1000,
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

## 汽车相关
### 查汽车
#### 简要描述
- 获取指定数量的汽车信息
#### 请求url：
- `/api/getcars`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
page|是|int|第几页
count|是|int|获取数量
type|是|int|类型[1/0]，1代表租赁了的，2代表未租赁

#### 返回格式
``` json
{
    "msg": "获取成功", 
    "code": 1000,
    "carinfos":
    [
        //具体信息
    ],
    "carcount":10
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 增加一个汽车
#### 简要描述
- 增加一个汽车
#### 请求url：
- `/api/insertcar`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
numberplate|是|String|车牌号
model|是|String|车型
color|是|String|颜色
status|是|String|空闲/租赁/保养中/加油中/xxxx...
endurancemail|是|int|可续航里程
statustime|是|int|状态时长
parkplace|否|String|停车位置
parkmoney|否|int|停车费
lease|否|int|1为租赁状态，2位未租赁状态

#### 返回格式
``` json
{
    msg: "添加成功", 
    code: 1000
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)

### 删除一个汽车
#### 简要描述
- 删除一个汽车
#### 请求url：
- `/api/deletecar`
#### 请求方式
- POST
#### 参数：
参数名|必选|类型|说明
-|-|-|-|
username|是|String|用户名
token|是|String|token
timestamp|是|String|13位当前时间戳
sign|是|string|[sign签名](#全局sign算法)
id|是|String|车id
#### 返回格式
``` json
{
    msg: "删除成功", 
    code: 1000,
}

```
#### 返回参数说明
参数名|必选|类型|说明
-|-|-|-|
msg|是|String|说明
code|是|int|[参加全局code](#全局code)