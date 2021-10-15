# 清理数据/sophon/v2/face/wipedata（POST）

**功能描述**

清空指定类型数据，包括人脸注册底库，权限组以及其它智能设置等等。</br>

**调用URL**

http://192.68.150.1:5555/sophon/v2/face/wipedata

调用方法: POST

**请求参数（JSON格式）**

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
        <td>users</td>
        <td>bool</td>
        <td>false</td>
        <td rowspan="3">必选，三选一 </td>
	    <td>true: 删除全部人脸底库、权限组和前端输入设备<br />false: 不删除</td>
	    <td></td>
	</tr> 
    <tr >
        <td>events</td>
        <td>bool</td>
        <td>false</td>
	    <td>true: 删除全部历史识别记录<br />false: 不删除</td>
	    <td></td>
	</tr>
    <tr >
        <td>all</td>
        <td>bool</td>
        <td>false</td>
	    <td>true: 除users和events外，还将智能设置恢复至默认值<br />false: 不动作</td>
	    <td></td>
	</tr>
</table>



请求示例：

```json
请求url: http://192.68.150.1:5555/sophon/v2/face/wipedata
请求方法：POST
请求body(JSON格式):
{	
    "users":true   //true为删除用户
}
```

**返回信息：**

请求成功

| 一级参数     |类型| 默认值  | 选择 | 描述                                                         | 示例 |
| :----------- | :--- | :--- |:--- | :----------------------------------------------------------- | :--- |
| result | bool |  |必选 | true: 清除数据成功<br />false: 清除数据失败 |      |

请求成功示例：

```json
{	
    "result":true
}
```
注意：</br>
此API调用为同步调用，在系统清除数据成功后即返回。调用者可直接根据http状态码判断执行结果，如果为200，表示执行成功。</br>
需要注意的是，本API在返回后会自动重启主机，如果调用者还有其它后续操作，需要等待主机重启成功后再继续进行。

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 3     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 4     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 5     | INTERNAL_ERROR         |                | 服务器内部错误，当此类错误发生时请再次请求，如果持续出现此类错误，请及时联系技术支持团队 |