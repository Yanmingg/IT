<template>
  <div style="z-index:0">
    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      :row-selection="rowSelection"
      @change="handleTableChange"
    >
      <template slot="name" slot-scope="name"> {{ name.first }} {{ name.last }} </template>
    </a-table>
  </div>
</template>
<script>
const queryData = {}
const columns = [
  {
    title: 'Name',
    dataIndex: 'name',
    sorter: true,
    width: '20%',
  },
  {
    title: 'Organization',
    dataIndex: 'organization',
    sorter: true,
    width: '20%',
  },
  {
    title: 'Email',
    dataIndex: 'email',
    width: '30%'
  },
  {
    title: 'Mobile',
    dataIndex: 'mobile',
    width: '20%'
  },
  {
    title: 'Tag',
    dataIndex: 'tag',
    sorter: true,
    width: '10%'
  },
];

const rowSelection = {
  onChange: (selectedRowKeys, selectedRows) => {
    console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
  },
  onSelect: (record, selected, selectedRows) => {
    console.log(record, selected, selectedRows);
  },
  onSelectAll: (selected, selectedRows, changeRows) => {
    console.log(selected, selectedRows, changeRows);
  },
};

export default {
  data() {
    return {
      data: [
      {
          key:1,
          name:"zhongli",
          organization:"liyue",
          email: "123@tl.com",
          mobile: "136263",
          tag: "star",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },

        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },

        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },
        {
          key:2,
          name:"raidian",
          organization:"daoqi",
          email: "128@tl.com",
          mobile: "123534",
          tag: "common",
        },

      ],
      pagination: {},
      loading: false,
      columns,
      rowSelection,
    };
  },
  mounted() {
    this.fetch();
  },
  methods: {
    handleTableChange(pagination, filters, sorter) {
      console.log(pagination);
      const pager = { ...this.pagination };
      pager.current = pagination.current;
      this.pagination = pager;
      this.fetch({
        results: pagination.pageSize,
        page: pagination.current,
        sortField: sorter.field,
        sortOrder: sorter.order,
        ...filters,
      });
    },
    fetch(params = {}) {
      this.loading = true;
      queryData({
        results: 10,
        ...params,
      }).then(({ data }) => {
        const pagination = { ...this.pagination };
        // Read total count from server
        // pagination.total = data.totalCount;
        pagination.total = 200;
        this.loading = false;
        this.data = data.results;
        this.pagination = pagination;
      });
    },
  },
};
</script>
