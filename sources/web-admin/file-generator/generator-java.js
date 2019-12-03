const path = require('path')
require('ts-node').register({ files: true })
// require('ts-node/register')
require('ts-node')
// require('../../dm-datacenter/data-show/src/main/java/com/dm/data/show/entity/cs')
require('./src/lib-java/generator-java').generate({
  source: path.resolve('../../dm-datacenter/data-show/src/main/java/com/dm/data/show/entity/cs'),
  target: path.resolve(__dirname, 'dist'),
  packageName: 'com.dm.data.show'
})
require('./src/lib-vue/generator-vue').generate({
  source: path.resolve('../../dm-datacenter/data-show/src/main/java/com/dm/data/show/entity/cs'),
  target: path.resolve(__dirname, 'dist')
})
