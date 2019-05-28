<template>
    <view>
        <view class="uni-padding-wrap uni-common-mt">
            <form @submit="formSubmit" @reset="formReset">
                <view class="uni-form-item uni-column">
                    <view class="title">用户名</view>
                    <input class="uni-input" name="username" placeholder="请输入用户名" />
                </view>
				<view class="uni-form-item uni-column">
				    <view class="title">密码</view>
				    <input class="uni-input" name="password" placeholder="请输入密码" />
				</view>
                <view class="uni-btn-v">
                    <button formType="submit">登录</button>
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
				chosen: ''
			}
		},
		methods: {
			formSubmit: function(e) {
				uni.request({
					url: this.$url+"user/user/login", //仅为示例，并非真实接口地址。
					data: e.detail.value,
					method:"POST",
					success: (res) => {
						if(res.data.code>0){
							alert(res.data.data.token);
							uni.setStorageSync('token',res.data.data.token);
							uni.setStorageSync("user",res.data.data.user);
							uni.switchTab({
								url: '/pages/index/index'
							})
						}else{
							uni.showModal({
								title:"错误",
								content:""+res.data.message
							});
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
