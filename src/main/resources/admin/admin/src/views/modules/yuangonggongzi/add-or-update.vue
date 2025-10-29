<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="基本工资" prop="jibengongzi" >
					<el-input-number v-model="ruleForm.jibengongzi" placeholder="基本工资" :disabled="ro.jibengongzi"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="基本工资" prop="jibengongzi" >
					<el-input v-model="ruleForm.jibengongzi" placeholder="基本工资" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="扣除五险一金" prop="kouchuwuxianyijin" >
					<el-input-number v-model="ruleForm.kouchuwuxianyijin" placeholder="扣除五险一金" :disabled="ro.kouchuwuxianyijin"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="扣除五险一金" prop="kouchuwuxianyijin" >
					<el-input v-model="ruleForm.kouchuwuxianyijin" placeholder="扣除五险一金" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="扣税" prop="koushui" >
					<el-input-number v-model="ruleForm.koushui" placeholder="扣税" :disabled="ro.koushui"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="扣税" prop="koushui" >
					<el-input v-model="ruleForm.koushui" placeholder="扣税" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="津贴" prop="jintie" >
					<el-input-number v-model="ruleForm.jintie" placeholder="津贴" :disabled="ro.jintie"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="津贴" prop="jintie" >
					<el-input v-model="ruleForm.jintie" placeholder="津贴" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="奖金" prop="jiangjin" >
					<el-input-number v-model="ruleForm.jiangjin" placeholder="奖金" :disabled="ro.jiangjin"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="奖金" prop="jiangjin" >
					<el-input v-model="ruleForm.jiangjin" placeholder="奖金" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'" label="最终工资" prop="zuizhonggongzi" >
					<el-input v-model="zuizhonggongzi" placeholder="最终工资" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zuizhonggongzi" label="最终工资" prop="zuizhonggongzi" >
					<el-input v-model="ruleForm.zuizhonggongzi" placeholder="最终工资" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="发放日期" prop="fafangriqi" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.fafangriqi" 
						type="date"
						:readonly="ro.fafangriqi"
						placeholder="发放日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.fafangriqi" label="发放日期" prop="fafangriqi" >
					<el-input v-model="ruleForm.fafangriqi" placeholder="发放日期" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="员工账号" prop="yuangongzhanghao" >
					<el-select :disabled="ro.yuangongzhanghao" @change="yuangongzhanghaoChange" v-model="ruleForm.yuangongzhanghao" placeholder="请选择员工账号">
						<el-option
							v-for="(item,index) in yuangongzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yuangongzhanghao" label="员工账号" prop="yuangongzhanghao" >
					<el-input v-model="ruleForm.yuangongzhanghao" placeholder="员工账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongxingming" >
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" clearable  :readonly="ro.yuangongxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="员工姓名" prop="yuangongxingming" >
					<el-input v-model="ruleForm.yuangongxingming" placeholder="员工姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="员工手机" prop="yuangongshouji" >
					<el-input v-model="ruleForm.yuangongshouji" placeholder="员工手机" clearable  :readonly="ro.yuangongshouji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="员工手机" prop="yuangongshouji" >
					<el-input v-model="ruleForm.yuangongshouji" placeholder="员工手机" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					jibengongzi : false,
					kouchuwuxianyijin : false,
					koushui : false,
					jintie : false,
					jiangjin : false,
					zuizhonggongzi : false,
					fafangriqi : false,
					yuangongzhanghao : false,
					yuangongxingming : false,
					yuangongshouji : false,
				},
			
				ruleForm: {
					jibengongzi: '',
					kouchuwuxianyijin: '',
					koushui: '',
					jintie: '',
					jiangjin: '',
					zuizhonggongzi: '',
					fafangriqi: '',
					yuangongzhanghao: '',
					yuangongxingming: '',
					yuangongshouji: '',
				},
				yuangongzhanghaoOptions: [],

				rules: {
					jibengongzi: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					kouchuwuxianyijin: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					koushui: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					jintie: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					jiangjin: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					zuizhonggongzi: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					fafangriqi: [
					],
					yuangongzhanghao: [
						{ required: true, message: '员工账号不能为空', trigger: 'blur' },
					],
					yuangongxingming: [
					],
					yuangongshouji: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			zuizhonggongzi: {
				get: function () {
					return 0+parseFloat(this.ruleForm.jibengongzi==""?0:this.ruleForm.jibengongzi)-parseFloat(this.ruleForm.kouchuwuxianyijin==""?0:this.ruleForm.kouchuwuxianyijin)-parseFloat(this.ruleForm.koushui==""?0:this.ruleForm.koushui)+parseFloat(this.ruleForm.jintie==""?0:this.ruleForm.jintie)+parseFloat(this.ruleForm.jiangjin==""?0:this.ruleForm.jiangjin) || 0
				}
			},



		},
		components: {
		},
		created() {
			this.ruleForm.fafangriqi = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='jibengongzi'){
							this.ruleForm.jibengongzi = obj[o];
							this.ro.jibengongzi = true;
							continue;
						}
						if(o=='kouchuwuxianyijin'){
							this.ruleForm.kouchuwuxianyijin = obj[o];
							this.ro.kouchuwuxianyijin = true;
							continue;
						}
						if(o=='koushui'){
							this.ruleForm.koushui = obj[o];
							this.ro.koushui = true;
							continue;
						}
						if(o=='jintie'){
							this.ruleForm.jintie = obj[o];
							this.ro.jintie = true;
							continue;
						}
						if(o=='jiangjin'){
							this.ruleForm.jiangjin = obj[o];
							this.ro.jiangjin = true;
							continue;
						}
						if(o=='zuizhonggongzi'){
							this.ruleForm.zuizhonggongzi = obj[o];
							this.ro.zuizhonggongzi = true;
							continue;
						}
						if(o=='fafangriqi'){
							this.ruleForm.fafangriqi = obj[o];
							this.ro.fafangriqi = true;
							continue;
						}
						if(o=='yuangongzhanghao'){
							this.ruleForm.yuangongzhanghao = obj[o];
							this.ro.yuangongzhanghao = true;
							continue;
						}
						if(o=='yuangongxingming'){
							this.ruleForm.yuangongxingming = obj[o];
							this.ro.yuangongxingming = true;
							continue;
						}
						if(o=='yuangongshouji'){
							this.ruleForm.yuangongshouji = obj[o];
							this.ro.yuangongshouji = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/yuangong/yuangongzhanghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.yuangongzhanghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			yuangongzhanghaoChange () {
				this.$http({
					url: `follow/yuangong/yuangongzhanghao?columnValue=`+ this.ruleForm.yuangongzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.jibengongzi){
							this.ruleForm.jibengongzi = data.data.jibengongzi
						}
						if(data.data.yuangongxingming){
							this.ruleForm.yuangongxingming = data.data.yuangongxingming
						}
						if(data.data.yuangongshouji){
							this.ruleForm.yuangongshouji = data.data.yuangongshouji
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `yuangonggongzi/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.zuizhonggongzi = this.zuizhonggongzi
					var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `yuangonggongzi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		padding: 40px 30px;
		background: #fff;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #6e6e6e;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 15px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #7841f0;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #39c9ee;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #9e46d1;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #70478e;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #b49be2;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
