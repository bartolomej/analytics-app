import React, {useState, useEffect} from 'react';
import clsx from 'clsx';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import {useStyles} from "../../styles/dashboard";
import { Graph } from 'react-d3-graph';
import {getAllNodes} from "../../api/AdminApi";

const data = {
  nodes: [{ id: 'Harry' }, { id: 'Sally' }, { id: 'Alice' }],
  links: [{ source: 'Harry', target: 'Sally' }, { source: 'Harry', target: 'Alice' }]
};

const myConfig = {
  nodeHighlightBehavior: true,
  node: {
    color: 'lightblue',
    size: 200,
    highlightStrokeColor: 'blue'
  },
  link: {
    highlightColor: 'lightblue'
  }
};

function parseGraph(graph) {
  let nodes = [];
  let links = [];

  graph.forEach(ele => {
    nodes.push({id: ele.uid});
    ele.edges.forEach(edge => {
      links.push({source: ele.uid, target: edge})
    })
  });

  return {nodes, links}
}

export default () => {
  const classes = useStyles();
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  const [nodes, setNodes] = useState({loading: true, error: null, data: data});

  useEffect(() => {
    const uid = 'ed715a73-4f35-4be2-b9ed-3b922850cbf6';
    const fetchData = async () => {
      const nodesRes = await getAllNodes(uid)
        .catch(e => setNodes({loading: false, error: e, data: []}));
      console.log('parsedGraph', parseGraph(nodesRes));
      if (nodesRes !== undefined) setNodes({loading: false, error: null, data: parseGraph(nodesRes)});
    };
    fetchData();
  }, []);

  const onClickNode = function(nodeId) {
    window.alert(`Clicked node ${nodeId}`);
  };

  return (
    <Container maxWidth="lg" className={classes.container}>
      <Grid container spacing={3}>
        <Graph
          id="graph-id" // id is mandatory, if no id is defined rd3g will throw an error
          data={nodes.data}
          config={myConfig}
          onClickNode={onClickNode}
        />
      </Grid>
    </Container>
  );
}
