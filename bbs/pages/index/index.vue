<template>
	<view class = "wrap">
		<view class="box">
			<view class="title">自定义样式</view>
			<t-table border="2" border-color="#95b99e" :is-check="true" @change="change">
				<t-tr font-size="14" color="#95b99e" align="left">
					<t-th align="left">操作人</t-th>
					<t-th align="left">花费</t-th>
					<t-th align="left">日期</t-th>
					<t-th align="left">描述</t-th>
					<t-th align="center">操作</t-th> 
				</t-tr>
				<t-tr font-size="12" color="#5d6f61" align="right" v-for="item in tableList" :key="item.id">
					<t-td align="left">{{ item.acountId }}</t-td>
					<t-td align="left">{{ item.acountNum }}</t-td>
					<t-td align="left">{{ item.acountDate }}</t-td>
					<t-td align="left">{{ item.acountDescription }}</t-td>
					<t-td align="left"><button @click="edit(item)">编辑</button></t-td>
				</t-tr>
			</t-table>
		</view>
		<view>
			<button @click="index">click</button>
			<button @click="show">tan</button>
		</view>
		<view>
			<uni-drawer :visible="flag" mode="right" @close="closeDrawer">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-list-cell-left">
							开始时间
						</view>
						<view class="uni-list-cell-db">
							<picker mode="date" :value="startDate" :start="startDate" :end="endDate" @change="bindDateChange">
								<view class="uni-input">{{startDate}}</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-list-cell-left">
							结束时间
						</view>
						<view class="uni-list-cell-db">
							<picker mode="date" :value="endDate" :start="startDate" :end="endDate" @change="bindDateChange">
								<view class="uni-input">{{endDate}}</view>
							</picker>
						</view>
					</view>
				</view>
				<view class="uni-form-item uni-column">
				    <view class="title">用户名</view>
				    <input class="uni-input" v-model="userId" :value="userId"/>
				</view>
				<view class="uni-form-item uni-column">
				    <view class="title">事情</view>
				    <input class="uni-input" v-model="des" :value = "des"/>
				</view>
			</uni-drawer>
		</view>
	</view>
</template>

<script>
	import tTable from '@/components/t-table/t-table.vue';
    import tTh from '@/components/t-table/t-th.vue';
    import tTr from '@/components/t-table/t-tr.vue';
    import tTd from '@/components/t-table/t-td.vue';
	import uniDrawer from "@/components/uni-drawer/uni-drawer.vue"
	export default {
		components: {
			tTable,
			tTh,
			tTr,
			tTd,
			uniDrawer,
		},
		data() {
			return {
				tableList: [],
				flag: false,
				startDate: "",
				endDate: "",
				userId: "",
				des: ""
			};
		},
		onShow() {
			this.request();
		},
		methods: {
			index: function(e){
				this.request();	
			},
			request:function(e){
				uni.request({
					url: this.$url+"acount/acount/acount",
					header:{
						token: uni.getStorageSync("token"),
					},
					data: {
						startDate: this.startDate,
						endDate: this.endDate, 
						userId: this.userId,
						des: this.des, 
					},
					method: "GET",
					success: (res)=>{
						if(res.data.code>0){
							this.tableList = res.data.data;
						}else if(res.data.code==0){
							alert(res.data.message);
							uni.navigateTo({
								url: "/pages/login/login/login"
							})
						}else{
							alert(res.data.message);
						}
					},
					fail: ()=>{
						alert("系统错误");
					}
					
				})	
			},
			show(){
				this.flag = true;
			},
			closeDrawer() {
				this.flag = false;
			},
			
		}
	}
</script>

<style>

</style>
