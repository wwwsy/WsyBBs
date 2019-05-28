<template>
	<view>
	    <view class="uni-padding-wrap uni-common-mt">
	        <form @submit="formSubmit" @reset="formReset">
	            <view class="uni-form-item uni-column">
	                <view class="title">花费</view>
	                <input class="uni-input" v-model="acountCost" name="acountCost" placeholder="请输入花费数 单位:元" />
	            </view>
				<view class="uni-form-item uni-column">
				    <view class="title">用途</view>
				    <input class="uni-input" v-model="acountDes" name="acountDes" placeholder="请输入用途"/>
				</view>
				<view>
					<view class="title">日期</view>
					<picker mode="date" :value="date" :start="startDate" :end="endDate" @change="bindDateChange">
						<view class="uni-input">{{date}}</view>
					</picker>
				</view>
	            <view class="uni-btn-v">
	                <button formType="submit">录入</button>
	                <button type="default" formType="reset">重置</button>
	            </view>
	        </form>
	    </view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				pickerHidden: true,
				chosen: '',
				acountCost: "",
				acountDes: "",
				userId: "",
				date:"",
			}
		},
		methods: {
			formSubmit: function(e) {
				uni.request({
					url: this.$url+"acount/acountTemp/acountTemp", //仅为示例，并非真实接口地址。
					header:{
						token: uni.getStorageSync("token"),
					},
					data: {
						acountCost: this.acountCost,
						acountDes: this.acountDes,
						userId: uni.getStorageSync("user").userId,
						date: this.date
					},
					method:"POST",
					success: (res) => {
						if(res.data.code>0){
							this.acountCost="";
							this.acountDes="";
							alert("保存成功");
						}else{
							alert("保存失败");
						}
					},
					fail: () => {
						alert("系统错误");
					}
				});
			},
			formReset: function(e) {
				this.chosen = ''
			}
		}
	}
</script>

<style>

</style>
