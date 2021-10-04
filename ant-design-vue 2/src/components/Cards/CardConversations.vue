<template>
<div>
	<!-- Conversations Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: 0 }">
		<template #title>

		</template>
		
		<a-list
			class="conversations-list"
			item-layout="horizontal"
			:split="true"
			:data-source="data"
		>
			<a-list-item slot="renderItem" slot-scope="item">
				<!-- <a-button slot="actions" type="link">
					REPLY
				</a-button> -->
				<a-list-item-meta style="text-align: left"
					:title="item.title"
					:description="item.code"
				>
					<!-- <a-avatar
					slot="avatar"
					:size="48"
					shape="square"
					:src="item.avatar"
					/> -->
				</a-list-item-meta>
			</a-list-item>
		</a-list>
	</a-card>
	<!-- / Conversations Card -->
</div>
</template>

<script>

	export default ({
		props: {
			data: {
				type: Array,
				default: () => [],
			},
		},
		data() {
			return {
			}
		},
	})

</script>

<style>
#components-affix-demo-target.scrollable-container {
  height: 100px;
  overflow-y: scroll;
}
#components-affix-demo-target .background {
  padding-top: 60px;
  height: 300px;
  background-image: url('https://zos.alipayobjects.com/rmsportal/RmjwQiJorKyobvI.jpg');
}
</style>