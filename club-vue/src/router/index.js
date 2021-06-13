import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/library',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: () => import('../components/home/AppIndex')
        },
        {
          path: '/ClubIndex',
          name: 'ClubIndex',
          component: () => import('../components/home/ClubIndex'),
          children: [
            {
              path: '/Clubforum',
              name: 'Clubforum',
              component: () => import('../components/home/Clubforum')
            },
            {
              path: '/ClubInform',
              name: 'ClubInform',
              component: () => import('../components/home/ClubInform')
            },
            {
              path: '/Clubplace',
              name: 'Clubplace',
              component: () => import('../components/home/Clubplace')
            },
            {
              path: '/ClubActivity',
              name: 'ClubActivity',
              component: () => import('../components/home/ClubActivity')
            },
            {
              path: '/ClubActivityD',
              name: 'ClubActivityD',
              component: () => import('../components/home/ClubActivityD')
            },
            {
              path: '/ClubMember',
              name: 'ClubMember',
              component: () => import('../components/home/ClubMember')
            },
            {
              path: '/ClubReserve',
              name: 'ClubReserve',
              component: () => import('../components/home/ClubReserve')
            },
            {
              path: '/ClubInformM',
              name: 'ClubInformM',
              component: () => import('../components/home/ClubInformM')
            },
            {
              path: '/ClubInformD',
              name: 'ClubInformD',
              component: () => import('../components/home/ClubInformD')
            },
            {
              path: '/ClubPlaceM',
              name: 'ClubPlaceM',
              component: () => import('../components/home/ClubPlaceM')
            },
            {
              path: '/ClubActivityM',
              name: 'ClubActivityM',
              component: () => import('../components/home/ClubActivityM')
            },
            {
              path: '/ClubReserveM',
              name: 'ClubReserveM',
              component: () => import('../components/home/ClubReserveM')
            },
            {
              path: '/ClubActivityM',
              name: 'ClubActivityM',
              component: () => import('../components/home/ClubActivityM')
            },
            {
              path: '/ClubIncomeM',
              name: 'ClubIncomeM',
              component: () => import('../components/home/ClubIncomeM')
            },
            {
              path: '/ClubMemberM',
              name: 'ClubMemberM',
              component: () => import('../components/home/ClubMemberM')
            }
          ]
        },
        {
          path: '/MemIndex',
          name: 'MemIndex',
          component: () => import('../components/home/MemIndex'),
          children: [
            {
              path: '/Clubforum1',
              name: 'Clubforum1',
              component: () => import('../components/home/Clubforum')
            },
            {
              path: '/ClubInform1',
              name: 'ClubInform1',
              component: () => import('../components/home/ClubInform')
            },
            {
              path: '/Clubplace1',
              name: 'Clubplace1',
              component: () => import('../components/home/Clubplace')
            },
            {
              path: '/ClubActivity1',
              name: 'ClubActivity1',
              component: () => import('../components/home/ClubActivity')
            },
            {
              path: '/ClubReserve1',
              name: 'ClubReserve1',
              component: () => import('../components/home/ClubReserve')
            },
            {
              path: '/ClubMember1',
              name: 'ClubMember1',
              component: () => import('../components/home/ClubMember')
            },
            {
              path: '/ClubInformD1',
              name: 'ClubInformD1',
              component: () => import('../components/home/ClubInformD')
            },
            {
              path: '/ClubActivityD1',
              name: 'ClubActivityD1',
              component: () => import('../components/home/ClubActivityD')
            },
          ]
        },
        {
          path: '/orders',
          name: 'Orders',
          component: () => import('../components/home/Orders')
        },
        {
          path: '/addClub',
          name: 'addClub',
          component: () => import('../components/home/addClub')
        },
        {
          path: '/car',
          name: 'Car',
          component: () => import('../components/home/Car')
        },
        {
          path: '/jotter',
          name: 'Jotter',
          component: () => import('../components/jotter/Articles')
        },
        {
          path: '/jotter/article',
          name: 'Article',
          component: () => import('../components/jotter/ArticleDetails')
        },
        {
          path: '/admin/content/editor',
          name: 'Editor',
          component: () => import('../components/admin/content/ArticleEditor'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/viewAct',
          name: 'viewAct',
          component: () => import('../components/admin/content/viewAct')
        },
        {
          path: '/library',
          name: 'Library',
          component: () => import('../components/library/LibraryIndex')
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../components/Login')
    },
     {
      path: '/login2',
      name: 'Login2',
      component: () => import('../components/Login2')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../components/Register')
    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('../components/admin/AdminIndex'),
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/admin/dashboard',
          name: 'Dashboard',
          component: () => import('../components/admin/dashboard/admin/index'),
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '*',
      component: () => import('../components/pages/Error404')
    }
  ]
})

// 用于创建默认路由
export const createRouter = routes => new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: () => import('../components/home/AppIndex')
        },
        {
          path: '/clubIndex',
          name: 'ClubIndex',
          component: () => import('../components/home/ClubIndex')
        },
        {
          path: '/MemIndex',
          name: 'MemIndex',
          component: () => import('../components/home/MemIndex')
        },
        {
          path: '/orders',
          name: 'Orders',
          component: () => import('../components/home/Orders')
        },
        {
          
          path: '/jotter',
          name: 'Jotter',
          component: () => import('../components/jotter/Articles')
        },
        {
          path: '/jotter/article',
          name: 'Article',
          component: () => import('../components/jotter/ArticleDetails')
        },
        {
          path: '/admin/content/editor',
          name: 'Editor',
          component: () => import('../components/admin/content/ArticleEditor'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: () => import('../components/library/LibraryIndex')
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../components/Login')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../components/Register')
    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('../components/admin/AdminIndex'),
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/admin/dashboard',
          name: 'Dashboard',
          component: () => import('../components/admin/dashboard/admin/index'),
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '*',
      component: () => import('../components/pages/Error404')
    }
  ]
})
