# -*- coding: UTF-8 -*-

require "mysql2"

client = Mysql2::Client.new(
	:host => '127.0.0.1',
	:username => 'root',
	:password => '123456',
	:database => 'course',
	:encoding => 'gbk'
)

client.query("update guestbook set time = '#{Time.now}'")

result = client.query("select * from guestbook")
result.each do |item|
	puts "#{item['id']} #{item['name']} #{item['time']}"# if item['id'] > 11 and item['id'] < 42
end