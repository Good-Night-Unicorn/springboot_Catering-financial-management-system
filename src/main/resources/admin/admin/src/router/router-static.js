import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import yuangong from '@/views/modules/yuangong/list'
	import yuangonggongzi from '@/views/modules/yuangonggongzi/list'
	import canyincaipin from '@/views/modules/canyincaipin/list'
	import mendianyuancailiao from '@/views/modules/mendianyuancailiao/list'
	import yuanliaojinhuo from '@/views/modules/yuanliaojinhuo/list'
	import caipindingdan from '@/views/modules/caipindingdan/list'
	import caipinfenlei from '@/views/modules/caipinfenlei/list'
	import yuanliaochuku from '@/views/modules/yuanliaochuku/list'
	import yuangongkaoqin from '@/views/modules/yuangongkaoqin/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/yuangong',
		name: '员工',
		component: yuangong
	}
	,{
		path: '/yuangonggongzi',
		name: '员工工资',
		component: yuangonggongzi
	}
	,{
		path: '/canyincaipin',
		name: '餐饮菜品',
		component: canyincaipin
	}
	,{
		path: '/mendianyuancailiao',
		name: '门店原材料',
		component: mendianyuancailiao
	}
	,{
		path: '/yuanliaojinhuo',
		name: '原料进货',
		component: yuanliaojinhuo
	}
	,{
		path: '/caipindingdan',
		name: '菜品订单',
		component: caipindingdan
	}
	,{
		path: '/caipinfenlei',
		name: '菜品分类',
		component: caipinfenlei
	}
	,{
		path: '/yuanliaochuku',
		name: '原料出库',
		component: yuanliaochuku
	}
	,{
		path: '/yuangongkaoqin',
		name: '员工考勤',
		component: yuangongkaoqin
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
