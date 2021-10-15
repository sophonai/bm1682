# 删除权限组/sophon/v2/face/deletepermission (POST)

**功能描述**

删除指定权限组。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/deletepermission

**调用方法**

POST

**请求参数**

<table>
	<tr>
	    <th>参数</th>
	    <th>类型</th>
	    <th>默认值</th> 
        <th>选择</th>
        <th>描述</th>
        <th>举例</th>
	</tr >
   	<tr >
        <td>permission_name</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一</td>
	    <td>权限组名称</td>
	    <td>”测试组“</td>
	</tr> 
   	<tr >
        <td>permission_id</td>
        <td>string</td>
        <td>无</td>
	    <td>全局唯一的权限组标识</td>
	    <td>”270ec5e6“</td>
	</tr> 
</table>
请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/deletepermission
请求方法：POST
请求body(JSON格式):
{
    "permission_id": "270ec5e6"
}
```

**返回信息：**

**请求成功**

| 一级参数      | 描述                               |
| :------------ | :--------------------------------- |
| permission_id | 如果删除成功，返回已删除的权限组id |

请求成功示例：

```json
{
    "permission_id": "test_id1"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | ID_NOT_FOUND           | 未找到的ID值   | ID未找到错误                                                 |
| 2     | ID_REPEAT_ERROR        | 重复的ID值     | ID重复错误                                                   |
| 3     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 4     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 5     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 6     | NAME_REPEAT_ERROR      | 重复的名字     | 名字重复错误。                                               |
| 7     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |