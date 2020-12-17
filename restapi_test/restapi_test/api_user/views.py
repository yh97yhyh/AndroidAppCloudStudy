from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import UserSerializer
from rest_framework import status
from .models import User

# Create your views here.

class UserView(APIView):
    ''' create '''
    def post(self, request):
        user_serializer = UserSerializer(data=request.data)
        if user_serializer.is_valid():
            user_serializer.save()
            return Response(user_serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(user_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    ''' read '''
    def get(self, request, **kwargs):
        if kwargs.get('u_id') is None: # query 안 들어왔을 때
            user_queryset = User.objects.all()
            user_queryset_serializer = UserSerializer(user_queryset, many=True)
            return Response(user_queryset_serializer.data, status=status.HTTP_200_OK)
        else:
            u_id = kwargs.get('u_id')
            user_serializer = UserSerializer(User.objects.get(id=u_id))
            return Response(user_serializer.data, status=status.HTTP_200_OK)
    
    ''' put '''
    def put(self, request, **kwargs): 
        if kwargs.get('u_id') is None:
            return Response('invalid request', status=status.HTTP_400_BAD_REQUEST)
        else:
            u_id = kwargs.get('u_id')
            user_object = User.objects.get(id=u_id)
            update_user_serializer = UserSerializer(user_object,
                    data=request.data)
            # request가 유효한지 체크
            if update_user_serializer.is_valid(): # 유효하면 저장
                update_user_serializer.save()
                return Response(update_user_serializer.data,
                        status=status.HTTP_200_OK)
            else:
                return Response('invalid request', status=status.HTTP_400_BAD_REQUEST)

    ''' delete '''
    def delete(self, request, **kwargs):
        if kwargs.get('u_id') is None: 
            return Response('invalid request', status=status.HTTP_400_BAD_REQUEST)
        else:
            u_id = kwargs.get('u_id')
            user_object = User.objects.get(id=u_id)
            user_object.delete()
            delete_serializer = UserSerializer(user_object)
            return Response(delete_serializer.data, status=status.HTTP_200_OK)
        
