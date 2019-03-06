<title>${functioncomment}管理</title>

<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>API调用</cite></a>
        <a><cite>${functioncomment}管理</cite></a>
    </div>
</div>
	
<div class="layui-fluid">
  <!-- 内容主体区域 -->
  <div class="layui-card">
      <div class="layui-tab-content">
          <div class="layui-field-box">
            <div class="layui-form">
              <div class="layui-form-item" style="text-align:center;">
                <div class="layui-inline">
                  <div class="layui-input-inline">
                    <input type="text" id="keyWord" name="keyWord" value="" lay-verify="required" placeholder="请输入关键词查询" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline" style="text-align:left;">
                  <div class="layui-input-inline">
                    <button class="layui-btn" id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                  </div>
                </div>
              </div>
            </div>
            <hr>
            <div class="layui-btn-group">
                <button class="layui-btn  layui-btn-normal" id="addBtn">
                    <i class="layui-icon">&#xe654;</i>新增
                </button>
                <button class="layui-btn  layui-btn-warm" id="editBtn">
                    <i class="layui-icon">&#xe642;</i>修改
                </button>
                <button class="layui-btn  layui-btn-danger" id="deleteBatchBtn">
                    <i class="layui-icon">&#xe640;</i>批量删除
                </button>
            </div>
            <hr>
            <table class="layui-hide" id="objTable" lay-filter="objT"></table>
          </div>
      </div>
  </div>
</div>
  
<script type="text/html" id="checkFlag">
  {{#  if(d.flag == "1"){ }}
    <span class="layui-badge">正常</span>
  {{#  } }}
  {{#  if(d.flag == "2"){ }}
    <span class="layui-badge layui-bg-cyan">禁用</span>
  {{#  } }}
</script>                
<script type="text/javascript" src="/admin-static/javascript/${classNameLowercase}/${classNameLowercase}.js"></script>
<script type="text/javascript" src="/admin-static/javascript/common/common.js"></script>
<script type="text/javascript" src="/admin-static/javascript/common/common-list.js"></script>