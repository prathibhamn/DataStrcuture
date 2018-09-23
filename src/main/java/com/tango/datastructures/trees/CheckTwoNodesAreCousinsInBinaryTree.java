package com.tango.datastructures.trees;
/*

10
/   \
5      20
/ \     / \ 
3   8   15 25 
/  
7
*/
public class CheckTwoNodesAreCousinsInBinaryTree {

    public static void main( String[] args )
    {

        Node rootNode = null;
        rootNode = addNode( rootNode, 10, true );
        rootNode = addNode( rootNode, 5, true );
        rootNode = addNode( rootNode, 20, true );
        rootNode = addNode( rootNode, 3, true );
        rootNode = addNode( rootNode, 8, true );
        rootNode = addNode( rootNode, 7, true );
        rootNode = addNode( rootNode, 15, true );
        rootNode = addNode( rootNode, 25, true );

        int a = 15;
        int b = 8;

        System.out.println( checkCousinRecursive( rootNode, a, b ) );
    }

    private static boolean checkCousinRecursive( Node start,
                                                 int node1Data,
                                                 int node2Data )
    {
        int levelNode1 = findLevel( start, node1Data, 0 );
        int levelNode2 = findLevel( start, node2Data, 0 );

        if( levelNode1 == -1 || levelNode2 == -1 )
        {
            return false;
        }

        if( levelNode1 != levelNode2 )
        {
            return false;
        }

        return isCousin( start, node1Data, node2Data );
    }

    private static boolean isCousin( Node startNode,
                                     int node1Data,
                                     int node2Data )
    {
        if( startNode == null )
        {
            return false;
        }

        if( startNode.getLeft() != null && startNode.getRight() != null )
        {
            if( ( startNode.getLeft().getData() == node1Data && startNode.getRight().getData() == node2Data )
                || ( startNode.getLeft().getData() == node2Data && startNode.getRight().getData() == node1Data ) )
            {
                return false; //if both node have same parent then they are sibling and not cousin
            }
        }

        boolean left = isCousin( startNode.getLeft(), node1Data, node2Data );
        if( !left )
        {
            return false;
        }
        boolean right = isCousin( startNode.getRight(), node1Data, node2Data );
        if( !right )
        {
            return false;
        }

        return true;
    }

    private static int findLevel( Node startNode,
                                  int nodeData,
                                  int level )
    {
        if( startNode == null )
        {
            return 0;
        }

        if( startNode.getData() == nodeData )
        {
            return level;
        }

        int left = findLevel( startNode.getLeft(), nodeData, level + 1 );
        if( left != 0 )
            return left;

        int right = findLevel( startNode.getRight(), nodeData, level + 1 );
        if( right != 0 )
            return right;

        return 0;
    }

    private static Node addNode( Node rootNode,
                                 int i,
                                 boolean isRootNode )
    {
        if( rootNode == null )
        {
            return new Node( i );
        }
        else
        {
            if( i > rootNode.getData() )
            {
                if( isRootNode )
                {
                    Node nodeToAdd = addNode( rootNode.getRight(), i, isRootNode );
                    rootNode.setRight( nodeToAdd );
                }
                else
                {
                    Node nodeToAdd = addNode( rootNode.getLeft(), i, isRootNode );
                    rootNode.setLeft( nodeToAdd );
                }

            }
            else
            {
                if( isRootNode )
                {
                    Node nodeToAdd = addNode( rootNode.getLeft(), i, isRootNode );
                    rootNode.setLeft( nodeToAdd );
                }
                else
                {
                    Node nodeToAdd = addNode( rootNode.getRight(), i, isRootNode );
                    rootNode.setRight( nodeToAdd );
                }
            }
        }
        return rootNode;
    }

}


