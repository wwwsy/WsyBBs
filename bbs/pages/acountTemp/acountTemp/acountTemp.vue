<template>
	<view>
		<view class="box">
			<view class="title">自定义样式</view>
			<t-table border="2" border-color="#95b99e" :is-check="true" @change="change">
				<t-tr font-size="14" color="#95b99e" align="left">
					<t-th align="left">录入人</t-th>
					<t-th align="left">花费</t-th>
					<t-th align="left">日期</t-th>
					<t-th align="left">描述</t-th>
					<t-th align="center">操作</t-th> 
				</t-tr>
				<t-tr font-size="12" color="#5d6f61" align="right" v-for="item in atList" :key="item.id">
					<t-td align="left">{{ item.atRecord }}</t-td>
					<t-td align="left">{{ item.atNum }}</t-td>
					<t-td align="left">{{ item.atTime }}</t-td>
					<t-td align="left">{{ item.atDescription }}</t-td>
					<t-td align="left"><button @click="back(item)">撤回</button>|<button @click="pass(item)">通过</button></t-td>
				</t-tr>
			</t-table>
		</view>
		<view>
			<button @click="allBack">全部撤回</button>
			<button @click="allPass">全部通过</button>
		</view>
	</view>
</template>

<script>
	import tTable from '@/components/t-table/t-table.vue';
	import tTh from '@/components/t-table/t-th.vue';
	import tTr from '@/components/t-table/t-tr.vue';
	import tTd from '@/components/t-table/t-td.vue';
	export default {
		components: {
			tTable,
			tTh,
			tTr,
			tTd,
		},
		data() {
			return {
				atList:[],
				atIds:[],
			}
		},
		onShow() {
			request();
		},
		methods: {
			allPass: function(e){
				post("tempAcount");
			},
			allBack: function(e){
				post("tempBack");
			},
			back: function(e){
				this.atIds = [];
				this.atIds[0] = e.atId;
				post("tempBack");
			},
			pass: function(e){
				this.atIds = [];
				this.atIds[0] = e.atId;
				post("tempAcount");
			},
			change: function(e){
				this.atIds = [];
				var index = 0;
				for(var k in e.detail){
					this.atIds[index++] = this.atList[e.detail[k]].atId;
				}
			},
			request: function(){
				uni.request({
					url: this.$url+"acount/acountTemp/acountTemp", //仅为示例，并非真实接口地址。
					header:{
						token: uni.getStorageSync("token"),
					},
					data: {
						userId: uni.getStorageSync("user").userId
					},
					method:"GET",
					success: (res) => {
						if(res.data.code>0){
							this.atList = res.data.data;
						}
					},
					fail: () => {
						alert("系统错误");
					}
				});
			},
			post: function(ads){
				uni.request({
					url: this.$url+"acount/acountTemp/"+ads, //仅为示例，并非真实接口地址。
					header:{
						token: uni.getStorageSync("token"),
					},
					data: {
						userId: uni.getStorageSync("user").userId,
						ids: this.atIds,
					},
					method:"POST",
					success: (res) => {
						if(res.data.code>0){
							request();
							uni.showModal({
								title: res.data.message,
							});
							this.atIds = [];
						}else if(res.data.code == 0){
							uni.showModal({
								title: res.data.message,
							});
							uni.navigateTo({
								url: "/pages/login/login/login",
							})
						}else{
							uni.showModal({
								title: res.data.message,
							})
						}
					},
					fail: () => {
						alert("系统错误");
					}
				});
			}
		}
	}
</script>

<style>

</style>
