<div class="row">
	<div class="col-md-12">
		<form id="dirAddForm">
				<div class="modal-body">
					<div class="form-group">
						<label id="dirUrlLabel">根目录</label>
						<input type="text" class="form-control" name="dirUrl" id="dirUrl" placeholder="输入目录地址...">
					</div>
					<div class="form-group">
						<label id="statusValueLabel">状态</label>
						<select class="form-control select2" style="width: 100%"
                                    name="statusValue" id="statusValue">
                                <option value="0" selected="selected">关闭</option>
                                <option value="1">开启</option>
                        </select>				
					</div>
				</div>
				<div class="modal-footer">
					<div class="pull-right">
						<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i>取消</button>
						<button type="button" class="btn btn-primary btn-sm" onclick="dirAdd();"><i class="fa fa-save"></i>保存</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
function dirAdd(){
	$("span").remove(".errorClass");
	$("br").remove(".errorClass");
	var status = 1;
	if($("#dirUrl").val()==""){
		$("#dirUrlLabel").prepend('<span class="errorClass" style="color:red">*角色名不能为空</span><br class="errorClass"/>');
		status = 0;
	}
	if($("#statusValue").val()==""){
		$("#statusValueLabel").prepend('<span class="errorClass" style="color:red">*角色值不能为空</span><br class="errorClass"/>');
		status = 0;
	}
	if(status == 0){
		return false;
	}else{
		$.ajax({
			url: '/dir/save',
	        type: 'post',
	        dataType: 'text',
	        data: $("#dirAddForm").serialize(),
	        success: function (data) {
				var json = JSON.parse(data);
				if (json.status){
                    $("#lgModal").modal('hide');
                    alertMsg("添加成功","success");
                    reloadTable(list_ajax,"#dirTime","#dirPremise");
				}else{
                    alertMsg("添加失败:"+json.msg,"success");
				}
	        }
		})
	}
}
</script>