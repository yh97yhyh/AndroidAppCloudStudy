from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import UserSerializer
from rest_framework import status
from .models import User

# Create your views here.

class UserView(APIView):
    def post(self, request):
        user_serializer = UserSerializer(data=request.data)
        if user_serializer.is_valid():
            user_serializer.save()
            return Response(user_serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(user_serializer.errors, status=status.HTTP_400_BAD_REQUEST)


    def get(self, request, **kwargs):
        if kwargs.get('u_id') is None: # query 안 들어왔을 때
            user_queryset = User.objects.all()
            user_queryset_serializer = UserSerializer(user_queryset, many=True)
            return Response(user_queryset_serializer.data, status=status.HTTP_200_OK)
        else:
            u_id = kwargs.get('u_id')
            user_serializer = UserSerializer(User.objects.get(id=u_id))
            return Response(user_serializer.data, status=status.HTTP_200_OK)
    
    def put(self, request, **kwargs):
        pass

    def delete(self, request, **kwargs):
        pass
